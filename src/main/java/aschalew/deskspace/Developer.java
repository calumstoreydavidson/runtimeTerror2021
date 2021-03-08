package aschalew.deskspace;

import java.util.List;

public class Developer extends Worker {
    List<String> skillList;

    public Developer(String company, String bonusPotential, List<String> skillList) {
        super(company, bonusPotential);
        this.skillList = skillList;
    }

    public Developer() {
    }

    public List<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<String> skillList) {
        this.skillList = skillList;
    }
}
