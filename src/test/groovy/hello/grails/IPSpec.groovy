package hello.grails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class IPSpec extends Specification implements DomainUnitTest<IP> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
