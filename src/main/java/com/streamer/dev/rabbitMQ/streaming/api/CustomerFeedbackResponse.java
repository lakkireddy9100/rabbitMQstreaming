package dev.rabbitMQ.streaming.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFeedbackResponse {

	@NotNull
	@Size(min = 1, max = 255)
	@Pattern(regexp = "^.{1,255}$")
	@WhitelistRegexValidator(regex = "[A-Za-z0-9_.,()*?!\\-\\s]")
	String meeting;
}
