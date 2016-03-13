Catálogo de Servicios
=====================
Pasos para la migracion a MAVEN:

1) Generar el pom.xml grails create-pom com.msssi
2) Crear un repo MAVEN, sin proxy ni nexus.
3) Solucionar el problema compilacion el plugin asset-pipeline-1.8.7
/*
import grails.plugin.webxml.FilterManager
*/
y tambien:
/*
    def getWebXmlFilterOrder() {
        ["AssetPipelineFilter": FilterManager.GRAILS_WEB_REQUEST_POSITION - 120]
    }
*/
4) Eliminar toda referencia a clientes Apache CXF en código
5) Importar ojdbc6 en local a MAVEN

mvn install:install-file -Dfile=D:\SOASUITE\interfaz\oracle_gamb\lib\ojdbc6.jar -DgroupId=com.racle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar

		<!-- ORACLE database driver -->
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>11.2.0</version>
		</dependency>
6) Probar que funciona: mvn grails:run-app (en el puerto 9000 como antes):

        <forkedVmArgs>
            <forkedVmArg>-Dserver.port=9000</forkedVmArg>
        </forkedVmArgs> 

7) Pedir a CalidadDesarrollo que suba a Nexus todas las librerias y plugins.
8) TO DO: generar clientes JAXB con plugin de maven.