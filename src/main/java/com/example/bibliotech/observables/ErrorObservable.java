package com.example.bibliotech.observables;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class ErrorObservable extends Observable {
    private boolean hasError;

    public boolean hasError() {
        return this.hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
        setChanged();
        notifyObservers();
    }

    public ErrorObservable() {
        this.hasError = false;
    }

    

    
}
