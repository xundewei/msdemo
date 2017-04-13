package msdemo.resources;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import msdemo.models.Book;
import msdemo.resources.exception.AppException;

/**
 * {
 * 1.查询 /book/querybook
 * 2.查询 /book/add_book
 * 3.查询 /book/update_book
 * 4.查询 /book/delete_book
 * }
 * @Author: TODY
 * @Version: V1.00
 * @Create Date: 2017年4月13日17:44:31
 * @Description:Book的资源类（查询，增加，修改，删除）
 */
@PermitAll()
@Path("book")
public class BookResource  {

    /**
     * 获取某本图书
     * @param bookId 书ID
     * @return 书对象
     */
    SecurityContext securityContext;
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    @Path("querybook")
    public Response querybook(@QueryParam("bookId") String bookId) throws AppException{
    	//数据方面暂且不实现
    	Book book1 = new Book();
    	book1.setBookID("0001");
    	book1.setBookName("星球大战_新增");
        return Response.ok(book1).build();
    }
    
    /**
     * 添加
     * POST方法
     * @param book  书对象
     * @return Response 
     */
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Path("add_book")
    public Response add_book(Book book) throws AppException{
    	//需要做图书的校验是否存在（没有数据库暂且不实现）
        return Response.ok(book).build();
    }
    /**
     * 更新
     * PUT方法
     * @param book  书对象
     * @return Response 
     */
    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Path("update_book")
    public Response update_book(Book book) throws AppException{
        //更新一本书数据库方面不再实现
        return Response.ok(book).build();

    }
    
    /**
     * 删除
     * DELETE方法
     * @param bookId  删除书ID
     * @return Response 
     */
    @DELETE
    @Consumes({ MediaType.APPLICATION_JSON })
    @Path("delete_book")
    public Response delete_book(@QueryParam("bookId") String bookId) throws AppException{
        //更新一本书数据库方面不再实现
        return Response.ok(bookId+"————————删除成功").build();

    }




}
