class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/admin/v1/dashboard"(controller: 'dashboard', namespace: 'adminV1')
        "/admin/v1/users/$action?"(controller: 'usuario', namespace: 'adminV1')

        "/"(view:"/error")
        "/admin"(view:"/admin/index")
        "500"(view:'/error')
	}
}
