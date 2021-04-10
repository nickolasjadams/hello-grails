package hello.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IPController {

    IPService IPService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond IPService.list(params), model:[IPCount: IPService.count()]
    }

    def show(Long id) {
        respond IPService.get(id)
    }

    def create() {
        respond new IP(params)
    }

    def save(IP IP) {
        if (IP == null) {
            notFound()
            return
        }

        try {
            IPService.save(IP)
        } catch (ValidationException e) {
            respond IP.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'IP.label', default: 'IP'), IP.id])
                redirect IP
            }
            '*' { respond IP, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond IPService.get(id)
    }

    def update(IP IP) {
        if (IP == null) {
            notFound()
            return
        }

        try {
            IPService.save(IP)
        } catch (ValidationException e) {
            respond IP.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'IP.label', default: 'IP'), IP.id])
                redirect IP
            }
            '*'{ respond IP, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        IPService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'IP.label', default: 'IP'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'IP.label', default: 'IP'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
