 package com.thread.lock;
/**
 * ���Զ��ٽ��������ر��ǻ����ʲô���ĺ����
 * @author ASUS
 *
 */
class Share{
	private int a;
	//����һ��������������3���̹߳�����һ������1����������������1����
	
	public Share(){
		a = 0;				//��������
	}
	
	public Share(int d){
		a = d;
	}
	//�ٽ���1���Թ����������ݼ�1
	public void add(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		a = a + 1;
		System.out.println("Add:"+a);
	}
	//�ٽ���2���Թ����������ݼ�1
		public void dec(){
			if(a>0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				a = a - 1;
				System.out.println("Dec:"+a);
			}
		}
}
 //�Թ�����������1�������߳�
class AddThread extends Thread{
	private Share s1;
	public AddThread(Share s3){
		s1 = s3;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			s1.add();    			//����1����
		}
	}
} 

//�Թ�����������1�������߳�
class DecThread extends Thread{
	private Share s2;
	public DecThread(Share s4){
		s2 = s4;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			s2.dec();    			//����1����
		}
	}
} 

//��Ϊ�ٽ����е�add()��dec()����������ԭ�Ӳ��������н�����ָ�ֵ���Ⲣ�����������ġ�
public class Test {
	public static void main(String[] args) {
		Share share = new Share();
		new AddThread(share).start();
		new DecThread(share).start();
		new DecThread(share).start();
	}
}