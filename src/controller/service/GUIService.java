package controller.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.skin.TableViewSkin;

public class GUIService {
//	private static Method columnToFitMethod;
//
//    static {
//        try {
//            columnToFitMethod = TableViewSkin.class.getDeclaredMethod("resizeColumnToFitContent", TableColumn.class, int.class);
//            columnToFitMethod.setAccessible(true);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//	public static void autoFitTable(TableView tableView) {
//        tableView.getItems().addListener(new ListChangeListener<Object>() {
//            @Override
//            public void onChanged(Change<?> c) {
//                for (Object column : tableView.getColumns()) {
//                    try {
//                        columnToFitMethod.invoke(tableView.getSkin(), column, -1);
//                    } catch (IllegalAccessException | InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
}
