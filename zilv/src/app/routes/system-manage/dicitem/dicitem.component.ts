import { Component, OnInit, ViewChild,TemplateRef } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ServicesService} from '../../../services/services.service';
import { NzMessageService, NzModalService } from 'ng-zorro-antd';
@Component({
  selector: 'app-system-manage-dicitem',
  templateUrl: './dicitem.component.html',
})
export class SystemManageDicitemComponent implements OnInit {
  //字典类型数据
  data:any[]=[];
  //字典配置数据    
  itemData:any[]=[];

  //字典类型模态框打开关闭
  isVisible=false;
  //字典配置模态框打开关闭
  isVisibleItem=false;
  //判断字典类型是添加还是修改
  typeAddorEdit='';
  //判断字典配置是添加还是修改
  typeAddorEditItem='';

  //字典类型模态框删除模态框打开关闭
  isVisibledelete = false;
  //字典配置模态框删除模态框打开关闭
   isVisibledeleteItem = false;
  //点击字典类型获取类型编号
  dictypeCode= '';
  
  dicpeizhiCode= '';
  //字典类型字段
  id='';
  dic_type_code='';
  dic_type_name='';

  itemID='';
  dicItemCode='';
  dicItemName='';
  @ViewChild('st') st: STComponent;
  columns: STColumn[] = [
    { title: '类型编号', index: 'dic_type_code' },
    { title: '类型名称', index: 'dic_type_name' },
    { title: '创建时间',  index: 'create_time' },
    {
      title: '操作',
      buttons: [
        {
          text: '编辑',
          click: (item: any) => {
            this.edit(item);
            this.typeAddorEdit='edit'
          },
        },
        {
          text: '删除',
          click: (item: any) => {
            this.delete(item);
          },
        },
      ]
    },
  ];


  @ViewChild('st') itemst: STComponent;
  columnsItem: STColumn[] = [
    { title: 'id', index: 'id',type: 'checkbox' },
    { title: '字典编号', index: 'dicItemCode' },
    { title: '字典名称', index: 'dicItemName' },
    { title: '创建时间',  index: 'createTime' },
    {
      title: '操作',
      buttons: [
        {
          text: '编辑',
          click: (item: any) => {
             this.editItem(item);
          },
        },
        {
          text: '删除',
          click: (item: any) => {
            this.deleteItem(item);
          },
        },
      ]
    },
  ];

  constructor(private http: _HttpClient, private modal: ModalHelper,private config:ServicesService,private msg: NzMessageService) { }

  ngOnInit() { 
       this.query();
  }
  //获取字典类型列表
  query(){
    this.http.post(this.config.url+'dic/dictypeList',
    {}
    ) .subscribe((res: any) => {
               this.data=res;     
      });
    
    }
    //字典类型列表点击事件
    dictypeClick(ele){
     if(ele.click!=null && ele.click!=undefined){
       console.log(ele)
       this.dicpeizhiCode=ele.click.item.dic_type_code;
       this.dictypeCode = ele.click.item.id;
       this.queryItem(ele.click.item.id);
     }
       
        
    }
    //获取字典配置列表
    queryItem(code){
      this.http.post(this.config.url+'dic/dicitemList',
      {code:code}
      ) .subscribe((res: any) => {
                 this.itemData = res;   
        });
    }
    //新增字典类型打开模态框
    add(){
      this.dic_type_code='';
      this.dic_type_name='';
      this.typeAddorEdit='add';
      this.isVisible = true;
    }
    //修改字典类型模态框打开
    edit(ele){
      this.dic_type_code=ele.dic_type_code;
      this.dic_type_name=ele.dic_type_name;
      this.id=ele.id;
      this.typeAddorEdit='edit';
      this.isVisible = true;
    }
    //字典类型模态框确定方法
    handleOk(): void {
      console.log(this.typeAddorEdit)
         if(this.typeAddorEdit=='add'){
            this.http.post(this.config.url+'dic/insertDictype',
            {dic_type_code:this.dic_type_code,dic_type_name:this.dic_type_name}
            ) .subscribe((res: any) => {
                        if(res==1){
                          this.msg.success('添加成功');
                          this.isVisible = false;
                          //刷新列表
                          this.query();     
                        }
              });
         }else if(this.typeAddorEdit=='edit'){
          this.http.post(this.config.url+'dic/updateDictype',
          {dic_type_code:this.dic_type_code,dic_type_name:this.dic_type_name,id:this.id}
          ) .subscribe((res: any) => {
                      if(res==1){
                        this.msg.success('修改成功');
                        this.isVisible = false;
                        //刷新列表
                        this.query();     
                      }
            });
         }
    }
    //字典类型点击删除
    delete(ele){
           this.id = ele.id;
           this.isVisibledelete = true;
    }
    //字典配置点击删除
    deleteItem(ele){
      this.itemID = ele.id;
      this.isVisibledeleteItem = true;
    }

    handledelete(){
      this.http.post(this.config.url+'dic/deleteDictype',
      {id:this.id}
      ) .subscribe((res: any) => {
                  if(res==1){
                    this.msg.success('删除成功');
                    this.isVisibledelete = false;
                    //刷新列表
                    this.query();     
                    this.queryItem(this.dictypeCode);  
                  }
        });  
    }
    //关闭类型模态框方法
    handleCancel(): void {
      this.isVisible = false;
    }
    //字典类型删除确认框关闭事件
    handleCanceldelete(){
      this.isVisibledelete = false;
    }
    
    //关闭配置模态框方法
    handleCancelItem(){
      this.isVisibleItem = false;
    }
    
    //字典配置删除确认框关闭事件
    handleCanceldeleteItem(){
      this.isVisibledeleteItem = false;
    }

    //新增字典类型打开模态框
    addItem(){
      if(this.dictypeCode!=''){
        this.dicItemCode='';
        this.dicItemName='';
        this.typeAddorEditItem='add';
        this.isVisibleItem = true;
      }else{
        this.msg.error('请选择字典类型');
      }
    
    }

    //修改字典类型模态框打开
    editItem(ele){
      this.dicItemCode=ele.dicItemCode;
      this.dicItemName=ele.dicItemName;
      this.itemID=ele.id;
      this.typeAddorEditItem='edit';
      this.isVisibleItem = true;
    }
    
    //字典类型模态框确定方法
    handleOkItem(): void {
         if(this.typeAddorEditItem=='add'){
            this.http.post(this.config.url+'dic/insertDicItem',
            {dicItemCode:this.dicItemCode,dicItemName:this.dicItemName,dicTypeId:this.dictypeCode}
            ) .subscribe((res: any) => {
                        if(res==1){
                          this.msg.success('添加成功');
                          this.isVisibleItem = false;
                          //刷新列表
                          this.queryItem(this.dictypeCode);     
                        }
              });
         }else if(this.typeAddorEditItem=='edit'){
          this.http.post(this.config.url+'dic/updateDicitem',
          {dicItemCode:this.dicItemCode,dicItemName:this.dicItemName,id:this.itemID}
          ) .subscribe((res: any) => {
                      if(res==1){
                        this.msg.success('修改成功');
                        this.isVisibleItem = false;
                        //刷新列表
                        this.queryItem(this.dictypeCode);     
                      }
            });
         }
    }

    handledeleteItem(){
      this.http.post(this.config.url+'dic/deleteDicitem',
      {id:this.itemID}
      ) .subscribe((res: any) => {
                  if(res==1){
                    this.msg.success('删除成功');
                    this.isVisibledeleteItem = false;
                    //刷新列表
                    this.queryItem(this.dictypeCode);     
                  }
        });  
    }


      //键盘回车事件
   keydown(data){
    if (data.keyCode === 13) {
      this.query();
    }
  }

}
