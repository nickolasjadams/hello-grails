package hello.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class IPServiceSpec extends Specification {

    IPService IPService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new IP(...).save(flush: true, failOnError: true)
        //new IP(...).save(flush: true, failOnError: true)
        //IP IP = new IP(...).save(flush: true, failOnError: true)
        //new IP(...).save(flush: true, failOnError: true)
        //new IP(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //IP.id
    }

    void "test get"() {
        setupData()

        expect:
        IPService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<IP> IPList = IPService.list(max: 2, offset: 2)

        then:
        IPList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        IPService.count() == 5
    }

    void "test delete"() {
        Long IPId = setupData()

        expect:
        IPService.count() == 5

        when:
        IPService.delete(IPId)
        sessionFactory.currentSession.flush()

        then:
        IPService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        IP IP = new IP()
        IPService.save(IP)

        then:
        IP.id != null
    }
}
