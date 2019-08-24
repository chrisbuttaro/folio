package folio

import org.example.User

class Portfolio {

    Date createdOn
    Date lastUpdated

    static hasMany = [comments: Comment]
    static belongsTo = [user: User]

    static constraints = {
        user(nullable: false)
        createdOn(nullable: false)
        lastUpdated(nullable: false)
        comments(nullable: true)

    }
}
