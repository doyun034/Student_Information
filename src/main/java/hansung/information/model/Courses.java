package hansung.information.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Courses {  // courses 테이블
    private int id;
    private String year;
    private Integer semester;
    private String class_code;
    private String class_name;
    private String class_type;
    private String professor;
    private Integer point;
}
