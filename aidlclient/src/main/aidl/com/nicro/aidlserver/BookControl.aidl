// BookControl.aidl
package com.nicro.aidlserver;
import com.nicro.aidlserver.Book;

interface BookControl {

    List<Book> getBookList();

    void addBookInOut(inout Book book);

}
