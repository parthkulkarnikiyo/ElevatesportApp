package com.sportapi.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportapi.model.ScoreCard;
import com.sportapi.repositories.ScoreCardRepository;
import com.sportapi.services.ScoreCardService;

@Service
public class ScoreCardServiceImpl implements ScoreCardService {

    @Autowired
    private ScoreCardRepository scoreCardRepository;

    @Override
    public List<ScoreCard> getAllScoreCards() {
        return scoreCardRepository.findAll();
    }

    @Override
    public Optional<ScoreCard> getScoreCardById(Long id) {
        return scoreCardRepository.findById(id);
    }

    @Override
    public ScoreCard saveScoreCard(ScoreCard scoreCard) {
        return scoreCardRepository.save(scoreCard);
    }

    @Override
    public void deleteScoreCard(Long id) {
        scoreCardRepository.deleteById(id);
    }

    public List<ScoreCard> getFinalScoreCards() {
        return scoreCardRepository.findByStatus("FINAL");
    }
    @Override
    public List<ScoreCard> getFinalScoreCardsByEventId(Long eventId) {
        return scoreCardRepository.findByEventIdAndStatus(eventId, "FINAL");
    }

  

    // New method to get final results

}
