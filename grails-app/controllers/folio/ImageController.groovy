package folio

import org.example.User

class ImageController {

    def renderCoverImage() {
        def selectedGallery = Gallery.findByName(params.id)
        if (selectedGallery?.coverImage) {
            response.setContentLength(selectedGallery.coverImage.size())
            response.outputStream.write(selectedGallery.coverImage)
        } else {
            response.sendError(404)
        }
    }

    def renderGalleryImage() {
        def selectedImage = Image.findByName(params.id)
        if (selectedImage) {
            response.setContentLength(selectedImageize())
            response.outputStream.write(selectedImage)
        } else {
            response.sendError(404)
        }
    }

    def createGalImage(ImageCommandObject ico) {
        Image image = new Image(ico.properties)
        User user = image.user
        if (!user.isAttached()) {
            user.attach()
        }
        Gallery gallery = Gallery.findByName(params.id)
        gallery.addToImages(image)
        image.addToGalleries(gallery)
        redirect controller:'Gallery', action:'gallery', model:[gallery:gallery, user:user]
    }

    

}

class ImageCommandObject {
    String name;
    byte[] src
    User user
    /*boolean featured
    Date createdOn*/
}
