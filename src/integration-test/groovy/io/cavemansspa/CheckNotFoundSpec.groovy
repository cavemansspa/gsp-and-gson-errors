package io.cavemansspa

import grails.converters.JSON
import grails.http.client.RxHttpClientBuilder
import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*
import static grails.http.HttpHeader.CONTENT_TYPE
import static grails.http.HttpStatus.CREATED
import static grails.http.HttpStatus.OK
import static grails.http.HttpStatus.NOT_FOUND
import static grails.http.MediaType.JSON
import static grails.http.MediaType.TEXT_XML

@Integration
@Rollback
class CheckNotFoundSpec extends Specification {

    @Shared RxHttpClientBuilder rest = new RxHttpClientBuilder()

    def setup() {
    }

    def cleanup() {
    }

    void "test not found"() {
        when:
        def resp = rest.get("http://localhost:${serverPort}/missing").toBlocking().first()

        then:
        resp.status == NOT_FOUND
        resp.toJson().toBlocking().first() == [message:'Not Found', error:404]
    }
}
