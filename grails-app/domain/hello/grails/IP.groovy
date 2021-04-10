package hello.grails

class IP {

    static belongsTo = [studio: Studio]
    String name
    String esrb
    String image
    double myRating

    static constraints = {
        name size: 2..40, blank: false, unique: true
        esrb size: 1..20, blank: true
        image size: 4..255, blank: true
        myRating blank: true
    }

    String toString() {
        name
    }
}
