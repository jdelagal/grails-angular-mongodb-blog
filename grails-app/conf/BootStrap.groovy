import com.grails.blog.auth.Role
import com.grails.blog.auth.Usuario

class BootStrap {

    def init = { servletContext ->

        Role roleAdmin = Role.findByAuthority("ROLE_ADMIN") ?:
            new Role(authority: "ROLE_ADMIN").save(failOnError: true)


         Usuario.findByUsername("admin") ?:
            new Usuario(username: 'admin',
                password: 'admin123',
                email: 'hussain.engr@gmail.com',
                name: 'Hussain Fakhruddin',
                authorities: [roleAdmin]).save(failOnError: true)
    }
    def destroy = {
    }
}
