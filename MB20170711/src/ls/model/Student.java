package ls.model;

public class Student {
    private Long id;

    private String name;

    private String sex;

    private String[] likes;

    
    
    public Student() {
    	System.out.println("============无参构造方法==========");
	}

	public Student(Long id, String name, String sex) {
		System.out.println("============有参构造方法==========");
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

	public String[] getLikes() {
		return likes;
	}

	public void setLikes(String[] likes) {
		this.likes = likes;
	}

}