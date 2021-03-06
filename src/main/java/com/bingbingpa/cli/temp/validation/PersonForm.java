package com.bingbingpa.cli.temp.validation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonForm {

	@NotNull
	@Size(max = 64)
	private String name;

	@Min(0)
	private int age;
}
