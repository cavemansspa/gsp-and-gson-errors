package githubissue

import grails.core.GrailsApplication
import grails.plugins.*

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

    def testContentNegotiation() {
        respond([message: 'this is a test'], view: 'testContentNegotiation')
    }
}
