package org.example

import folio.Address
import folio.Comment
import folio.Gallery
import folio.Image
import folio.Portfolio
import folio.Profile
import folio.Purchase
import folio.PurchaseItem
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    static hasOne = [folio: Portfolio, profile: Profile]
    static hasMany = [items : PurchaseItem, purchases: Purchase,
                      images: Image, following: User, comments: Comment, addresses: Address, galleries:Gallery]


    private static final long serialVersionUID = 1

    String username
    String password
    String email
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        email nullable: false, blank: false, unique: true, email: true
        username nullable: false, blank: false, unique: true
        password(nullable: false)
        folio(nullable: true)
        profile(nullable: true)
        items(nullable: true)
        images(nullable: true)
        purchases(nullable: true)
        following(nullable: true)
        galleries(nullable: true)
    }

    static mapping = {
	    password column: '`password`'
    }
}
