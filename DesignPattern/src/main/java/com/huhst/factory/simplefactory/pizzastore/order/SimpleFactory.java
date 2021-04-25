package com.huhst.factory.simplefactory.pizzastore.order;

import com.huhst.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.huhst.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.huhst.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.huhst.factory.simplefactory.pizzastore.pizza.Pizza;

//�򵥹�����
public class SimpleFactory {

	//����orderType ���ض�Ӧ��Pizza ����
	public Pizza createPizza(String orderType) {

		Pizza pizza = null;

		System.out.println("ʹ�ü򵥹���ģʽ");
		if ("greek".equals(orderType)) {
			pizza = new GreekPizza();
			pizza.setName(" ϣ������ ");
		} else if ("cheese".equals(orderType)) {
			pizza = new CheesePizza();
			pizza.setName(" �������� ");
		} else if ("pepper".equals(orderType)) {
			pizza = new PepperPizza();
			pizza.setName("��������");
		}
		
		return pizza;
	}
	
	//�򵥹���ģʽ Ҳ�� ��̬����ģʽ 
	
	public static Pizza createPizza2(String orderType) {

		Pizza pizza = null;

		System.out.println("ʹ�ü򵥹���ģʽ2");
		if ("greek".equals(orderType)) {
			pizza = new GreekPizza();
			pizza.setName(" ϣ������ ");
		} else if ("cheese".equals(orderType)) {
			pizza = new CheesePizza();
			pizza.setName(" �������� ");
		} else if ("pepper".equals(orderType)) {
			pizza = new PepperPizza();
			pizza.setName("��������");
		}
		
		return pizza;
	}

}
