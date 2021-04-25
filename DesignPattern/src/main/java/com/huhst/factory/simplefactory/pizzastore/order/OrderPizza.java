package com.huhst.factory.simplefactory.pizzastore.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import com.huhst.factory.simplefactory.pizzastore.pizza.Pizza;

/**
 * @author panbailiang
 */
public class OrderPizza {

	// ������
//	public OrderPizza() {
//		Pizza pizza = null;
//		String orderType; // ��������������
//		do {
//			orderType = getType();
//			if (orderType.equals("greek")) {
//				pizza = new GreekPizza();
//				pizza.setName(" ϣ������ ");
//			} else if (orderType.equals("cheese")) {
//				pizza = new CheesePizza();
//				pizza.setName(" �������� ");
//			} else if (orderType.equals("pepper")) {
//				pizza = new PepperPizza();
//				pizza.setName("��������");
//			} else {
//				break;
//			}
//			//���pizza ��������
//			pizza.prepare();
//			pizza.bake();
//			pizza.cut();
//			pizza.box();
//			
//		} while (true);
//	}

	//����һ���򵥹�������
	SimpleFactory simpleFactory;
	Pizza pizza = null;
	
	//������
	public OrderPizza(SimpleFactory simpleFactory) {
		setFactory(simpleFactory);
	}
	
	public void setFactory(SimpleFactory simpleFactory) {
		//�û������
		String orderType = "";
		//���ü򵥹�������
		this.simpleFactory = simpleFactory;
		
		do {
			orderType = getType(); 
			pizza = this.simpleFactory.createPizza(orderType);
			
			//���pizza
			//�����ɹ�
			if(pizza != null) {
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.out.println(" ��������ʧ�� ");
				break;
			}
		}while(true);
	}
	
	/** дһ�����������Ի�ȡ�ͻ�ϣ����������������*/
	private String getType() {
		try {
			BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza ����:");
			String str = string.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
