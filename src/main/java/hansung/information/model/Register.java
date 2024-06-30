package hansung.information.model;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Register { //register 테이블
    private int id;

    @NotNull(message="반드시 입력바랍니다")
    @Pattern(regexp = "\\d{4}", message = "년도는 반드시 4자리 숫자로 입력바랍니다")
    private String year;

    @NotNull(message="반드시 입력바랍니다")
    @Min(value = 1, message = "학기는 1 또는 2로 입력바랍니다")
    @Max(value = 2, message = "학기는 1 또는 2로 입력바랍니다")
    private Integer semester;

    @NotEmpty(message="반드시 입력바랍니다")
    @Pattern(regexp = "[a-zA-Z0-9]{7}", message = "클래스 코드는 7자리 숫자와 알파벳만 입력바랍니다")
    private String class_code;

    @NotEmpty(message="반드시 입력바랍니다")
    @Size(min=2, max=25, message = "최소 2글자, 최대 25글자만 입력바랍니다")
    private String class_name;

    @NotEmpty(message="반드시 입력바랍니다")
    @Size(min=2, max=10, message = "최소 2글자, 최대 10글자만 입력바랍니다")
    private String class_type;

    @NotEmpty(message="반드시 입력바랍니다")
    @Size(min=2, max=20, message = "최소 2글자, 최대 20글자만 입력바랍니다")
    private String professor;

    @NotNull(message="반드시 입력바랍니다")
    @Min(value = 0, message = "포인트는 0에서 9 사이의 숫자여야 합니다")
    @Max(value = 9, message = "포인트는 0에서 9 사이의 숫자여야 합니다")
    private Integer point;
}
