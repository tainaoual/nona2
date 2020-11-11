package org.wcci.apimastery.storages;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Albums;
import org.wcci.apimastery.resources.Songs;

@Service
public class SongStorage {

        private SongsRepository songsRepo;

        public  SongStorage(SongsRepository songsRepo) {
            this.songsRepo = songsRepo;
        }
        public Songs RetrieveSongsById(Long id ){

            return songsRepo.findById(id ).get();
        }

        public Iterable<Songs> retrieveAllSongs(){

            return songsRepo.findAll();
        }
        public void  saveSongs(Songs songsToSave){
            songsRepo.save(songsToSave);
        }
        public void deleteASongById (Long id){
            songsRepo.deleteById(id);
        }


    }






