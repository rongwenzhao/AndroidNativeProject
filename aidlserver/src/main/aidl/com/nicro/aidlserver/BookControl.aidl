// BookControl.aidl
package com.nicro.aidlserver;
import com.nicro.aidlserver.Book;

interface BookControl {

    List<Book> getBookList();

    void addBookInOut(inout Book book);

    void addBookIn(in Book book);

    void addBookOut(out Book book);

}
