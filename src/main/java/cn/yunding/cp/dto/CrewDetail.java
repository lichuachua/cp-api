package cn.yunding.cp.dto;

import java.util.Date;

public class CrewDetail {
    /**
     * 成员名，也就是昵称
     */
    private String crewName;

    /**
     * 创建时间
     */
    private Date createAt;

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "CrewDetail{" +
                "crewName='" + crewName + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
