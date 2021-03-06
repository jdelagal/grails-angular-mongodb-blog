package com.grails.blog.admin

import com.grails.blog.auth.Usuario
import com.grails.blog.auth.Role
import com.grails.blog.auth.UserRole
import com.grails.blog.command.UsuarioPassword

import static org.springframework.http.HttpStatus.*

class UsuarioController {

    static namespace = 'adminV1'
    static responseFormats = ['json', 'xml']

    def springSecurityService

    def profile() {
        def currentUser = springSecurityService.getCurrentUser()
        if (currentUser) {
            respond Usuario.get(currentUser.id), [excludes: ['class','password']]
        } else {
            render status: NOT_FOUND
        }
    }

    def updateProfile(Usuario userInstance) {
        def currentUser = springSecurityService.getCurrentUser()
        if (!currentUser) {
            render status: NOT_FOUND
            return
        }


        userInstance.id = currentUser.id
        userInstance.validate()
        if (userInstance.hasErrors()) {
            respond userInstance.errors
            return
        }

        if (grailsApplication.config.blog.updates.enabled) {
            userInstance.save flush:true
        }

        respond userInstance, [status: OK, excludes: ['class','password']]
    }

    def password(UsuarioPassword password) {
        def currentUserId = springSecurityService.getCurrentUser().id
        Usuario currentUser = Usuario.get(currentUserId)

        if (!currentUser) {
            render status: NOT_FOUND
            return
        }

        if (currentUser.password.equals(springSecurityService.encodePassword(password.currentPassword))) {
            if (password.newPassword.equals(password.confirmPassword)) {
                currentUser.password = password.newPassword
                /*
                if (grailsApplication.config.blog.updates.enabled) {
                    currentUser.save()
                }
                */

                currentUser.save()
                render status: OK
            } else {
                password.errors.reject(
                        'userPassword.newPassword.doesnotmatch',
                        '[Property [{0}] of class [{1}] does not match confirmation]')

                password.errors.rejectValue('newPassword','userPassword.newPassword.doesnotmatch',
                        '[Property [{0}] of class [{1}] does not match confirmation]')

                respond password.errors
                return
            }
        } else {
            
            password.errors.reject(
                    'userPassword.oldPassword.doesnotmatch',
                    '[Property [{0}] of class [{1}] is incorrect]')
            currentUser.save()
            render status: OK                    
            
            println "currentUser.password: "+currentUser.password
            println "password.currentPassword: "+password.currentPassword
            println "springSecurityService.encodePassword(password.currentPassword): "+springSecurityService.encodePassword(password.currentPassword)    
            println "password.validate(): " + password.validate()
        }

        password.validate()
        if (password.hasErrors()) {
            respond password.errors
            return
        }

        if (grailsApplication.config.blog.updates.enabled) {
            currentUser.save flush:true
        }

        respond currentUser, [status: OK]
    }
}
