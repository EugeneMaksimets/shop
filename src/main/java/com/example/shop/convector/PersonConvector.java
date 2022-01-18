package com.example.shop.convector;

import com.example.shop.dto.PersonDTO;
import com.example.shop.model.Cart;
import com.example.shop.model.Person;
import com.example.shop.storage.CartStorage;

public class PersonConvector {

    public static PersonDTO convectorToDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        Cart cart = new Cart();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        for (Cart tmp : CartStorage.cartStorageList) {
            if (tmp.getId().equals(person.getCartId())) {
                cart = tmp;
            }
            personDTO.setCart(cart);
        }
        return personDTO;
    }

}

