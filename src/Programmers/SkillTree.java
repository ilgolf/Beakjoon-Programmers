package Programmers;

import java.util.*;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        List<String> skillTree = new ArrayList<>(Arrays.asList(skill_trees));
        skillTree.removeIf(s -> skill.indexOf(s.replaceAll("[^" + skill + "]", "")) != 0);
        return skillTree.size();
    }
}
