package com.numbergame.service;

import com.numbergame.entity.Levels;
import com.numbergame.repository.LevelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelsService {
    @Autowired
    LevelsRepository levelsRepository;


    public Boolean addLevel(Levels levels){
        levelsRepository.save(levels);
        return true;
    }

    public Boolean deleteLevel(Long levelNumber){
        try {
            Levels levels = levelsRepository.findByLevelNumber(levelNumber);
            if (levels==null) throw new Exception("Invalid Level Number");
            levelsRepository.delete(levels);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Boolean updateLevel(Long levelId, Levels updatedLevelDetails){


        return true;
    }
}
