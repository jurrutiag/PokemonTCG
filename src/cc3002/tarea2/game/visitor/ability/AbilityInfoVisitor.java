package cc3002.tarea2.game.visitor.ability;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;

import java.util.ArrayList;

public class AbilityInfoVisitor extends AbstractAbilityVisitor {

    private ArrayList<String> infoStrings = new ArrayList<>();

    @Override
    public void visitAttack(IAttack attack) {
        infoStrings.add("Type: Attack");
    }

    @Override
    public void visitAbility(IAbility ability) {
        infoStrings.add("Name: " + ability.getName());
        infoStrings.add("Description: " + ability.getDescription());
    }

    public ArrayList<String> getStrings() {
        return this.infoStrings;
    }
}
