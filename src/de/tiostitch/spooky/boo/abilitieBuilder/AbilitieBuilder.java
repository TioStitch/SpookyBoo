package de.tiostitch.spooky.boo.abilitieBuilder;

import de.tiostitch.spooky.boo.abilitieBuilder.abilities.Abilities;
import de.tiostitch.spooky.boo.abilitieBuilder.abilities.BatFirework;

public final class AbilitieBuilder {

    public static AbilitieImpl getAbilitie(Abilities abilities) {
        switch (abilities) {
            case BAT_FIREWORK:
                return new BatFirework();
        }
        return null;
    }
}
