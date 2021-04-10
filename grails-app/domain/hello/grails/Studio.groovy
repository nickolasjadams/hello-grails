package hello.grails

class Studio {

    String name
    Boolean crossPlatform
    String logo
    static hasMany = [ips: IP]
    static mapping = {
        ips sort: 'myRating', order: 'desc'
    }

    static constraints = {
        name size: 3..40, blank: false, unique: true
        crossPlatform blank: false
        logo size: 4..255, blank: true
    }

    String toString() {
        name
    }
}
