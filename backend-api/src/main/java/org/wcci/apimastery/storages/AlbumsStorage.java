package org.wcci.apimastery.storages;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Albums;

@Service
public class AlbumsStorage {

   private AlbumsRepository albumsRepo;

   public  AlbumsStorage(AlbumsRepository albumsRepo) {
       this.albumsRepo = albumsRepo;
   }
   public Albums RetrieveAlbumsById(Long id ){

       return albumsRepo.findById(id ).get();
   }

    public Iterable<Albums> retrieveAllAlbums(){

       return albumsRepo.findAll();
    }
    public void  saveAlbums(Albums albumsToSave){
     albumsRepo.save(albumsToSave);
}
    public void deleteAlbumsById (Long id){
       albumsRepo.deleteById(id);
    }


}
