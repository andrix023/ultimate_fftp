package com.example.fromfridgetoplate.patterns.factory;

// rappresenta l'interfaccia ProductBase ma con i tipi generics, per dare piu flessibilià alle varie DAO su cosa passare
// come parametro ai metodi , e cosa ritornare
public interface BaseDAO<I, O>{

    void set(I entity);
    O get(I id);

}
// utilità dubbia , lasciare per future