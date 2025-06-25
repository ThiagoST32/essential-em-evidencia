package org.example.minevidencia.essentialEmEvidencia.apply;

public class VerifyIncreaseSpeed {

    public VerifyIncreaseSpeed() {
    }

    public boolean isValidSpeedIncrease(int speedIncrease) {
        return speedIncrease <= 4 && speedIncrease >= 0;
    }
}
