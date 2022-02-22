package thymeleafCurd.model;



import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
	private Integer stdId;
	private String stdName;
	private String stdGen;
	private Double stdFee;
	private String stdCourse;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> stdSlot;
	private String stdAddr;

}
