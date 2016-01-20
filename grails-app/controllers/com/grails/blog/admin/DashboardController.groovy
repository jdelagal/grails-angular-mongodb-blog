package com.grails.blog.admin

import com.grails.blog.command.Dashboard
import com.grails.blog.Servicio

class DashboardController {

    static namespace = 'adminV1'
    static responseFormats = ['json', 'xml']

    def index() {
        Dashboard dashboard = new Dashboard()
        dashboard.activePages = 1
        dashboard.inActivePages = 0
        dashboard.activePosts = 0
        dashboard.inActivePosts = 0

        def instServ = Servicio.findAll()
        println instServ.servicio

        respond dashboard
    }
}
