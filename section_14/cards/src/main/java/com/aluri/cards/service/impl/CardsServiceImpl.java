package com.aluri.cards.service.impl;

import com.aluri.cards.constant.CardsConstants;
import com.aluri.cards.dto.CardsDto;
import com.aluri.cards.entity.Cards;
import com.aluri.cards.exception.CardAlreadyExistException;
import com.aluri.cards.exception.ResourceNotFoundException;
import com.aluri.cards.mapper.CardsMapper;
import com.aluri.cards.repository.CardsRepository;
import com.aluri.cards.service.CardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class CardsServiceImpl implements CardsService {

    private CardsRepository cardsRepository;

    @Override
    public CardsDto getCardDetails(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        CardsDto newCard = CardsMapper.mapToCardsDto(cards, new CardsDto());
        return newCard;
    }

    @Override
    public void addNewCard(String mobileNumber) {
        Optional<Cards> newCard = cardsRepository.findByMobileNumber(mobileNumber);
        if(newCard.isPresent()) {
            throw new CardAlreadyExistException("Customer is already assigned a card with mobile number " + mobileNumber);
        }
            cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }


    @Override
    public boolean updateCardDetails(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return  true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }
}
