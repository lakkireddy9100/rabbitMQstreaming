package dev.rabbitMQ.streaming.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerFeedbackRequest {

	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z]*)*$")
	@ApiModelProperty(example = "dev")
	String initialMessage;

	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z]*)*$")
	@ApiModelProperty(example = "User")
	String lastMessage;
}
