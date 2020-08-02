
package com.yc.test.dao;

import java.util.List;
import java.util.Map;

import com.yc.test.entity.GoodsInfo;

public interface IGoodsInfoDao {
	public List<GoodsInfo> findBypage(int page, int row);
	public int total();
	public int total(String tno, String gname);
	public List<GoodsInfo> findByCondition(String tno, String gname, int page, int rows);
	public List<GoodsInfo> findIndex();
	public GoodsInfo findByGno(String gno);
	public List<GoodsInfo> findByTno(String tno,int page,int rows);
	public int total(String tno);


}
