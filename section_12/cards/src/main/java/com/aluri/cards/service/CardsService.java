package com.aluri.cards.service;

import com.aluri.cards.dto.CardsDto;

public interface CardsService {

    CardsDto getCardDetails(String mobileNumber);

    void addNewCard(String mobileNumber);

    boolean updateCardDetails(CardsDto cardsDto);

    boolean deleteCard(String mobileNumber);

}
