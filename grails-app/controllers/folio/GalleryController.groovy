package folio

import org.example.User

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class GalleryController {


   def create(CreateGalleryCommand cgc) {
       def user = session.user
       if (!user.isAttached()) {
           user.attach()
       }
       Gallery newGallery = new Gallery(cgc.properties)
    //   newGallery.validate()
       newGallery.user = user
       newGallery.save(flush: true)
       redirect controller: "portfolio", action: "folio",
               params: [id: "$user.username"]
    }

    def gallery () {
        Gallery gallery = Gallery.findByName(params.id)
        User user = gallery.user
        if (!user.isAttached()) {
            user.attach()
        }
        [user:user, gallery:gallery]
    }

}

class CreateGalleryCommand {
    String name
    byte [] coverImage
}

