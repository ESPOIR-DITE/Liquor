package company.com.service.payment.customerPay.impl;


import company.com.domain.customerPayment.impl.Card;
import company.com.repository.payment.customerPay.CardRepInt;
import company.com.service.payment.customerPay.CardInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardRepService implements CardInt {
    @Autowired
    CardRepInt cardRepInt;
    private static CardRepService cardRep=null;

    private CardRepService() {
    }
    public static CardRepService getCardRep(){
        if(cardRep==null){
            cardRep=new CardRepService();
        }return cardRep;
    }


    @Override
    public Card create(Card card) {
        return cardRepInt.save(card);
    }

    @Override
    public Card update(Card card) {
        return cardRepInt.save(card);
    }

    @Override
    public void delete(String id) {
        cardRepInt.deleteById(id);
    }

    @Override
    public Card read(String id) {
        Optional<Card> result=cardRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Card> readAll() {
        return cardRepInt.findAll();
    }
}
