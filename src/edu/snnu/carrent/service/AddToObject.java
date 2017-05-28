package edu.snnu.carrent.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * 通过反射来返回json数据
 */
public class AddToObject {

	public static JSONObject addToJson(Object object)
			throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchFieldException,
			ClassNotFoundException {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		String setname = null;

		// 如果传入的对象不为空
		if (object != null && object instanceof Object) {

			// 获取这个对象的所有属性
			Field[] fields = object.getClass().getDeclaredFields();

			// 遍历这个对象的所有属性
			for (Field field : fields) {
				// 获取这个对象的get方法
				Method m = (Method) object.getClass().getMethod(
						"get" + getMethodName(field.getName()));
				// 通过某个属性的get方法找到这个属性的值
				Object obj = m.invoke(object);
				// 如果对象的某个属性值不为空
				if (obj != null) {
					// 如果对象的某个属性的类型为集合
					if (obj instanceof Set) {
						// 获得一个迭代器
						Iterator it = ((Set) obj).iterator();
						// 通过迭代器遍历集合里面的每一个对象
						while (it.hasNext()) {
							Object objectSet = it.next();
							Class type = objectSet.getClass();
							setname = type.getSimpleName();
							System.out.println(objectSet.getClass()
									.getSimpleName());
							// 获取集合内的对象的的对应ID属性的属性名
							Field[] f = objectSet.getClass()
									.getDeclaredFields();
							for (Field field2 : f) {
								// 获取集合内的对象的的对应ID属性的get方法
								Method m2 = (Method) objectSet.getClass()
										.getMethod(
												"get"
														+ getMethodName(field2
																.getName()));
								// 获取集合内的对象的的对应ID属性的属性值
								Object val = m2.invoke(objectSet);
								// 把集合内的一个对象的对应ID放在一个json对象里
								JSONObject j = new JSONObject();
								j.put(field2.getName(), val);
								// 把集合内的所有对象的json对象放在一个json数组里
								jsonArray.add(j);
							}
						}
						if (setname == null) {

						} else {
							jsonObject.put(setname, jsonArray);
						}
					} else {
						// 如果此属性不是集合，那么把他加入到jsonObject对象中
						jsonObject.put(field.getName(), obj);
					}
				}
			}
		}
		int status = 200;
		String message = "OK";

		JSONObject js = new JSONObject();
		js.put("status", 200);
		js.put("message", message);
		js.put("contents", jsonObject);
		return js;
	}

	// 把属性名的首字母变为大写
	public static String getMethodName(String fieldName) {
		byte items[] = fieldName.getBytes();
		if (items[0] > 64 && items[0] < 97)
			items[0] = (byte) ((char) items[0] + 'a' - 'A');
		else
			items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}
}
