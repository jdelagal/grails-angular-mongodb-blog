
dataSource {
    pooled = true
    driverClassName = "oracle.jdbc.OracleDriver"
    username = "CATALOGO"
    password = "gobiernosoa"
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    //    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    temp.use_jdbc_metadata_defaults = false
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            dialect = "org.hibernate.dialect.Oracle10gDialect"
            url = "jdbc:oracle:thin:@localhost:1521:xe"         
        }
    }

    test {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            dialect = "org.hibernate.dialect.Oracle10gDialect"
            url = "jdbc:oracle:thin:@localhost:1521:xe"             
        }
    }
    
    production {
        dataSource {            
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            dialect = "org.hibernate.dialect.Oracle10gDialect"
            url = "jdbc:oracle:thin:@localhost:1521:xe"
        }
    }
}