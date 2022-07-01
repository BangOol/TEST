package com.yedam.myserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yedam.myserver.emp.vo.Employee;

public class LambdaTest {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();

		// lombok - builder를 통해, 생성자를 사용하지 않고 곧바로 값을 대입할 수 있다.
		list.add(Employee.builder().email("a@a.c").salary(1000).build());
		list.add(Employee.builder().email("za@za.c").salary(2000).build());
		list.add(Employee.builder().email("aa@aa.c").salary(3000).build());
		list.add(Employee.builder().email("cc@bb.c").salary(4000).build());

		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() - o2.getSalary();
			}	
		}); // 익명클래스 : 클래스선언과 생성
			
		// 람다식 : 부모 인터페이스의 오버라이딩 할 메서드가 1개일 경우.
		Collections.sort(list, (Employee o1, Employee o2) -> o1.getSalary() - o2.getSalary() );
			
		for (Employee emp : list) {
			System.out.println(emp.getEmail() + ":" + emp.getSalary());
		}
	}
}

//class SalaryComp implements Comparator<Employee> {
//
//	@Override
//	public int compare(Employee o1, Employee o2) {
//		// TODO Auto-generated method stub
//		return o1.getSalary() - o2.getSalary();
//	}

	class EmpComp implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return o1.getEmail().compareTo(o2.getEmail());
		}

	}


