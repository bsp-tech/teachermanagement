package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Section;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SectionDataInter extends CrudRepository<Section,Integer> {
    
    @Query(value = "select s from Section s where s.playlistUrl=?1 or s.threadFilesPath=?2 or s.thumbnailPath=?3")
    public List<Section> getSectionsBySearching(String playlistUrl,String threadFilesPath,String thumbnailPath);
}
