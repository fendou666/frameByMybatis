package ls.model;

import java.util.List;

public class ClassName {
    private Integer id;
    private String name;
    private List<Student> stuList;
    
    public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "ClassName [id=" + id + ", name=" + name + ", stuList="
				+ stuList + "]";
	}

}