package hello.grails

import grails.gorm.services.Service

@Service(IP)
interface IPService {

    IP get(Serializable id)

    List<IP> list(Map args)

    Long count()

    void delete(Serializable id)

    IP save(IP IP)

}